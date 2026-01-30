package prescribersystem.core;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import prescribersystem.SymptomEnum;
import prescribersystem.core.interfaces.DoneObserver;
import prescribersystem.rules.AttractiveRule;
import prescribersystem.rules.Covid19Rule;
import prescribersystem.rules.SleepApneaSyndromeRule;

public class Prescriber {

    private PatientDatabase patientDatabase;

    private final List<String> diseases = new ArrayList<>();
    private final List<DoneObserver> doneObservers = new ArrayList<>();

    private final BlockingQueue<Demand> jobs = new LinkedBlockingQueue<>();

    private final AtomicBoolean running = new AtomicBoolean(false);
    private Thread worker;

    public Prescriber(PatientDatabase patientDatabase, String diseases) {
        for (String disease : diseases.split(",")) {
            this.diseases.add(disease.trim());
        }
        this.patientDatabase = patientDatabase;
    }

    public synchronized void start() {
        if (running.get())
            return;

        running.set(true);

        worker = new Thread(this::runLoop, "prescriber-worker");
        worker.setDaemon(true);
        worker.start();
    }

    public synchronized void submit(Demand demand) {
        PrintStream client = demand.getClient();

        client.println("Processing prescription for patient ID: " + demand.getPatientId());

        String path = demand.getPath();

        Prescription prescription = prescribe(demand, diseases);

        List<SymptomEnum> symptoms = demand.getSymptoms();
        Case caseData = new Case(symptoms, prescription, LocalDate.now());

        notifyDoneObservers(client, patientDatabase, caseData, path);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void stop() {
        running.set(false);
        worker.interrupt();
    }

    public void registerDoneObserver(DoneObserver observer) {
        doneObservers.add(observer);
    }

    public void removeDoneObserver(DoneObserver observer) {
        doneObservers.remove(observer);
    }

    public void notifyDoneObservers(PrintStream client, PatientDatabase db, Case caseData, String path) {
        for (DoneObserver observer : doneObservers) {
            observer.handle(client, db, caseData, path);
        }
    }

    private Prescription prescribe(Demand demand, List<String> activeHandlers) {
        return new Covid19Rule(new AttractiveRule(new SleepApneaSyndromeRule(null))).handle(demand, activeHandlers);
    }

    private void runLoop() {
        while (running.get()) {
            try {
                Demand demand = jobs.take();
                submit(demand);
            } catch (InterruptedException e) {
                if (!running.get())
                    break;
                Thread.currentThread().interrupt();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

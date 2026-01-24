package rpg.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rpg.role.action.*;
import rpg.role.observer.DeathObserver;
import rpg.role.state.NormalState;
import rpg.role.state.State;
import rpg.troop.Troop;

public abstract class Role {

	protected String name;
	protected int hp;
	protected int mp;
	protected int str;
	protected Troop troop;
	protected State state;
	protected List<Action> actions = new ArrayList<>();

	protected Map<Role, DeathObserver> deathObservers = new HashMap<>();

	public Role(String input, Troop troop) {
		String[] parts = input.trim().split("\\s+");

		this.name = parts[0];
		this.hp = Integer.parseInt(parts[1]);
		this.mp = Integer.parseInt(parts[2]);
		this.str = Integer.parseInt(parts[3]);

		this.actions.add(new BasicAttack(this.str));

		if (parts.length > 4) {
			for (int i = 4; i < parts.length; i++) {
				String skillName = parts[i];
				this.actions.add(createSkill(skillName));
			}
		}

		this.state = new NormalState();
		this.troop = troop;
	}

	public abstract Action selectAction();

	public abstract List<Role> SelectTargets(Action action, List<Role> candidates);

	public void takeAction(Action action, List<Role> targets) {
		this.consumeMp(action.getMp());
		action.handle(targets, this);
	}

	public Troop getTroop() {
		return troop;
	}

	public int getTroopNumber() {
		return troop.getNumber();
	}

	public boolean isAlive() {
		return this.hp > 0;
	}

	public String getName() {
		return this.name;
	}

	public int getHp() {
		return this.hp;
	}

	public int getMp() {
		return this.mp;
	}

	public int getStr() {
		return this.str;
	}

	protected Action getAction(int index) {
		return actions.get(index);
	}

	protected String getActionName(int index) {
		return actions.get(index).getName();
	}

	protected int getActionsSize() {
		return actions.size();
	}

	public boolean hasEnoughMP(int cost) {
		return this.mp >= cost;
	}

	public void takeDamage(int damage) {
		this.hp -= damage;
	}

	public void consumeMp(int cost) {
		this.mp -= cost;
	}

	public void heal(int amount) {
		this.hp += amount;
	}

	public void die() {
		this.hp = 0;
		notifyDeathObservers();
	}

	public boolean canMove() {
		return this.state.canMove(this);
	}

	public String getStateName() {
		return this.state.getName();
	}

	public void enterState(State newState) {
		if (this.state != null) {
			this.state.exit();
		}
		this.state = newState;
		this.state.enter();
	}

	public void onTurnStart() {
		this.state.onTurnStart(this);
	}

	public void onTurnEnd() {
		this.state.onTurnEnd(this);
	}

	public int adjustDamage(int damage) {
		return this.state.adjustDamage(damage);
	}

	public void registerDeathObserver(DeathObserver observer, Role caster) {
		deathObservers.put(caster, observer);
	}

	public void notifyDeathObservers() {
		for (DeathObserver observer : deathObservers.values()) {
			observer.update(this.mp);
		}
	}

	private Action createSkill(String skillName) {
		switch (skillName) {
			case "鼓舞" :
				return new CheerUpSkill();
			case "下毒" :
				return new PoisonSkill();
			case "詛咒" :
				return new CurseSkill();
			case "石化" :
				return new PetrochemicalSkill();
			case "自我治療" :
				return new SelfHealingSkill();
			case "召喚" :
				return new SummonSkill();
			case "一拳攻擊" :
				return new OnePunchSkill();
			case "水球" :
				return new WaterBallSkill();
			case "火球" :
				return new FireBallSkill();
			case "自爆" :
				return new SelfExplosionSkill();
			default :
				throw new IllegalArgumentException("Unknown skill: " + skillName);
		}
	}
}

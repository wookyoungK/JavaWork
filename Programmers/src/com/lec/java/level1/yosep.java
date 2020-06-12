package com.lec.java.level1;

enum VendorID {
	LG, HYUNDAI, SAMSUNG
}

enum MotorStatus {
	MOVING, STOPPED
}

enum DoorStatus {
	CLOSED, OPENED
}

enum Direction {
	UP, DOWN
}

class ElevatorFactoryFactory {
	public static ElevatorFactory getFactory(VendorID vendorID) {
		ElevatorFactory factory = null;

		switch (vendorID) {

		case LG:

			factory = LGElevatorFactory.getInstance();
			break;
		case HYUNDAI:

			factory = HyundaiElevatorFactory.getInstance();
			break;
		case SAMSUNG:

			factory = SamsungElevatorFactory.getInstance();
			break;
		}
		return factory;
	}
}

abstract class ElevatorFactory {

	public abstract Motor createMotor();

	public abstract Door createDoor();
}

class HyundaiElevatorFactory extends ElevatorFactory {

	private static ElevatorFactory factory;

	private HyundaiElevatorFactory() {
	}

	public static ElevatorFactory getInstance() {

		if (factory == null)
			factory = new HyundaiElevatorFactory();

		return factory;
	}

	public Motor createMotor() {

		return new HyundaiMotor();
	}

	public Door createDoor() {

		return new HyundaiDoor();
	}
}

class LGElevatorFactory extends ElevatorFactory {

	private static ElevatorFactory factory;

	private LGElevatorFactory() {
	}

	public static ElevatorFactory getInstance() {

		if (factory == null)
			factory = new LGElevatorFactory();
		return factory;
	}

	public Motor createMotor() {

		return new LGMotor();
	}

	public Door createDoor() {

		return new LGDoor();
	}
}

class SamsungElevatorFactory extends ElevatorFactory {

	private static ElevatorFactory factory;

	private SamsungElevatorFactory() {
	}

	public static ElevatorFactory getInstance() {

		if (factory == null)
			factory = new SamsungElevatorFactory();
		return factory;
	}

	public Motor createMotor() {

		return new SamsungMotor();
	}

	public Door createDoor() {

		return new SamsungDoor();
	}
}

class HyundaiMotor extends Motor {

	protected void moveMotor(Direction direction) {

		System.out.println("[TempleteMethod Pattern4] move Hyundai Motor \n");
	}
}

class LGMotor extends Motor {

	protected void moveMotor(Direction direction) {

		System.out.println("[Templete Method Pattern4] move LG Motor \n");
	}
}

class SamsungMotor extends Motor {

	protected void moveMotor(Direction direction) {

		System.out.println("[TempleteMethod Pattern4] move Samsung Motor \n");
	}
}

abstract class Door {

	private DoorStatus doorStatus;

	public Door() {
		doorStatus = DoorStatus.CLOSED;
	}

	public DoorStatus getDoorStatus() {
		return doorStatus;
	}

	public void close() {

		if (doorStatus == DoorStatus.CLOSED)
			return;
		doClose();

		doorStatus = DoorStatus.CLOSED;
	}

	protected abstract void doClose();

	public void open() {

		if (doorStatus == DoorStatus.OPENED)
			return;
		doOpen();

		doorStatus = DoorStatus.OPENED;
	}

	protected abstract void doOpen();
}

class HyundaiDoor extends Door

{

	protected void doClose() {

		System.out.println("[Templete Method Pattern4] close Hyundai Door");
	}

	protected void doOpen() {

		System.out.println("[Templete Method Pattern4] open Hyundai Door");
	}
}

class LGDoor extends Door {

	protected void doClose() {

		System.out.println("[Templete Method Pattern4] close LG Door");
	}

	protected void doOpen() {

		System.out.println("[Templete Method Pattern4] open LG Door");
	}
}

class SamsungDoor extends Door {

	protected void doClose() {

		System.out.println("[Templete Method Pattern4] close Samsung Door");
	}

	protected void doOpen() {

		System.out.println("[Templete Method Pattern4] open Samsung Door");
	}
}

abstract class Motor {

	private Door door;
	private MotorStatus motorStatus;

	public Motor() {
		motorStatus = MotorStatus.STOPPED;
	}

	public void setDoor(Door door) {

		this.door = door;
	}

	public MotorStatus getMotorStatus() {

		return motorStatus;
	}

	private void setMotorStatus(MotorStatus motorStatus) {

		this.motorStatus = motorStatus;
	}

	public void move(Direction direction) {

		MotorStatus motorStatus = getMotorStatus();

		if (motorStatus == MotorStatus.MOVING)
			return;
		DoorStatus doorStatus = door.getDoorStatus();

		if (doorStatus == DoorStatus.OPENED)
			door.close();

		moveMotor(direction);
		setMotorStatus(MotorStatus.MOVING);
	}

	protected abstract void moveMotor(Direction direction);
}

public class yosep {

	public static void main(String[] args) {

		String vendorName = args[0];
		VendorID vendorID;

		if (vendorName.equalsIgnoreCase("LG"))
			vendorID = VendorID.LG;
		else if (vendorName.equalsIgnoreCase("Samsung"))
			vendorID = VendorID.SAMSUNG;
		else
			vendorID = VendorID.HYUNDAI;

		System.out.println(" ***  Abstract Factory Pattern (Singleton)  ***");

		ElevatorFactory factory = ElevatorFactoryFactory.getFactory(vendorID);

		Door door = factory.createDoor();
		Motor motor = factory.createMotor();

		motor.setDoor(door);
		door.open();
		motor.move(Direction.UP);
	}
}

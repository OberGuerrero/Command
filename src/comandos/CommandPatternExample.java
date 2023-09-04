package comandos;
class Television {
    public void turnOn() {
        System.out.println("TV turned on");
    }

    public void turnOff() {
        System.out.println("TV turned off");
    }
}

class Light {
    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light turned off");
    }
}

// Command interface
interface Command {
    void execute();
}

// Concrete command classes
class TurnOnTVCommand implements Command {
    private Television tv;

    public TurnOnTVCommand(Television tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}

class TurnOffTVCommand implements Command {
    private Television tv;

    public TurnOffTVCommand(Television tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOff();
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Main class
public class CommandPatternExample {
    public static void main(String[] args) {
        Television tv = new Television();
        Light light = new Light();

        Command turnOnTV = new TurnOnTVCommand(tv);
        Command turnOffTV = new TurnOffTVCommand(tv);
        Command turnOnLight = new TurnOnLightCommand(light);
        Command turnOffLight = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnTV);
        remote.pressButton();

        remote.setCommand(turnOffTV);
        remote.pressButton();

        remote.setCommand(turnOnLight);
        remote.pressButton();

        remote.setCommand(turnOffLight);
        remote.pressButton();
    }
}

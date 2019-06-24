package com.controlframework;

import sun.util.resources.ga.LocaleNames_ga;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-24 18:13
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";

    private class LightOn extends AbstractEvent {
        public LightOn(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }

        @Override
        public String description() {
            return "Light is on";
        }
    }

    private class LightOff extends AbstractEvent {
        public LightOff(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn off the light.
            light = false;
        }

        @Override
        public String description() {
            return "Light is off";
        }
    }

    private class WaterOn extends AbstractEvent {
        public WaterOn(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            // Put hardware control code here
            water = true;
        }

        @Override
        public String description() {
            return "Greenhouse water is on";
        }
    }

    private class WaterOff extends AbstractEvent {
        public WaterOff(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            // Put hardware control code here
            water = false;
        }

        @Override
        public String description() {
            return "Greenhouse water is off";
        }
    }

    private class ThermostatNight extends AbstractEvent {
        public ThermostatNight(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            // Put hardware control code here
            thermostat = "Night";
        }

        @Override
        public String description() {
            return "Thermostat on night setting";
        }
    }

    private class ThermostatDay extends AbstractEvent {
        public ThermostatDay(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            // Put hardware control code here
            thermostat = "Day";
        }

        @Override
        public String description() {
            return "Thermostat on day setting";
        }
    }

    private int rings;

    private class Bell extends AbstractEvent {
        public Bell(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            // Put hardware control code here
            System.out.println("Bing!");
            if (--rings > 0) {
                addEvent(new Bell(System.currentTimeMillis() + 2000));
            }
        }

        @Override
        public String description() {
            return "Ring bell";
        }
    }

    private class Restart extends AbstractEvent {

        public Restart(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            long tm = System.currentTimeMillis();
            rings = 5;
            addEvent(new ThermostatNight(tm));
            addEvent(new LightOn(tm + 1000));
            addEvent(new LightOff(tm + 2000));
            addEvent(new WaterOn(tm + 3000));
            addEvent(new WaterOff(tm + 8000));
            addEvent(new Bell(tm + 9000));
            addEvent(new ThermostatDay(tm + 10000));
            //addEvent(new Restart(tm + 20000));
        }

        @Override
        public String description() {
            return "Restarting system";
        }
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        long tm = System.currentTimeMillis();
        gc.addEvent(gc.new Restart(tm));
        gc.run();
    }
}

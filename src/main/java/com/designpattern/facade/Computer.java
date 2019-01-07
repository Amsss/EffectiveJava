package com.designpattern.facade;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:32
 */
public class Computer {
    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup() {
        System.out.println("start the computer!");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finished!");
    }

    public void shutdown() {
        System.out.println("begin to close the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer closed!");
    }
} 

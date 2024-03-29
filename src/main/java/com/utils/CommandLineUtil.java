package com.utils;

import org.apache.commons.cli.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-08-07 17:01
 */
public class CommandLineUtil {
    public static void main(String[] args) {
        parseOptions(args);
    }

    //java [-options] class [args...]
    private static void parseOptions(String[] args) {
        Options options = new Options();

        //第一个参数是选项名称的缩写，第二个参数是选项名称的全称，第三个参数表示是否需要额外的输入，第四个参数表示对选项的描述信息
        Option opt_help = new Option("h", "help", false, "print help message");
        opt_help.setRequired(false);
        options.addOption(opt_help);

        Option opt_version = new Option("v", "version", false, "print version and exit");
        opt_version.setRequired(false);
        options.addOption(opt_version);

        //用来打印帮助信息
        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);

        CommandLine commandLine = null;
        CommandLineParser parser = new DefaultParser();

        try {
            commandLine = parser.parse(options, args);
            if (commandLine.hasOption("h")) {
                hf.printHelp("testApp", options, true);
            }
            if (commandLine.hasOption("v")) {
                System.out.println("version 0.0.1");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

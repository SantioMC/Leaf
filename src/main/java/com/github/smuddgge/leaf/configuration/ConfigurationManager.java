package com.github.smuddgge.leaf.configuration;

import com.github.smuddgge.leaf.configuration.handlers.CommandConfigurationHandler;
import com.github.smuddgge.leaf.configuration.handlers.PlaceholderConfigurationHandler;
import com.github.smuddgge.leaf.configuration.handlers.VariableConfigurationHandler;

import java.io.File;

/**
 * Manages all the configuration files.
 */
public class ConfigurationManager {

    private static File folder;

    private static CommandConfigurationHandler commandsConfigurationHandler;
    private static PlaceholderConfigurationHandler placeholderConfigurationHandler;
    private static VariableConfigurationHandler variableConfigurationHandler;

    /**
     * Used to initialise the configuration manager.
     *
     * @param folder The plugin's folder.
     */
    public static void initialise(File folder) {
        ConfigurationManager.folder = folder;

        ConfigurationManager.commandsConfigurationHandler = new CommandConfigurationHandler(folder);
        ConfigurationManager.placeholderConfigurationHandler = new PlaceholderConfigurationHandler(folder);
        ConfigurationManager.variableConfigurationHandler = new VariableConfigurationHandler(folder);

        ConfigMain.initialise(folder);
        ConfigDatabase.initialise(folder);
        ConfigMessages.initialise(folder);
    }

    /**
     * Used to reload all the configuration files.
     */
    public static void reload() {
        ConfigurationManager.getCommands().reload();
        ConfigurationManager.getPlaceholders().reload();
        ConfigurationManager.getVariables().reload();

        ConfigMain.initialise(folder);
        ConfigDatabase.initialise(folder);
        ConfigMessages.initialise(folder);
    }

    public static CommandConfigurationHandler getCommands() {
        return ConfigurationManager.commandsConfigurationHandler;
    }

    public static PlaceholderConfigurationHandler getPlaceholders() {
        return ConfigurationManager.placeholderConfigurationHandler;
    }

    public static VariableConfigurationHandler getVariables() {
        return ConfigurationManager.variableConfigurationHandler;
    }
}

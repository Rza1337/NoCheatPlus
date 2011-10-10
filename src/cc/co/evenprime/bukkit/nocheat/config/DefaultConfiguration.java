package cc.co.evenprime.bukkit.nocheat.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cc.co.evenprime.bukkit.nocheat.actions.ActionList;
import cc.co.evenprime.bukkit.nocheat.actions.ActionManager;
import cc.co.evenprime.bukkit.nocheat.log.LogLevel;

/**
 * The place where the structure of the configuration tree is defined, the
 * default settings are defined, the default files are defined.
 * 
 * @author Evenprime
 * 
 */
public class DefaultConfiguration extends Configuration {

    public DefaultConfiguration(ActionManager action) {
        super(null, false);

        /*** LOGGING ***/
        {
            setValue(LOGGING_ACTIVE, true);
            setValue(LOGGING_FILENAME, "nocheat.log");
            setValue(LOGGING_FILELEVEL, LogLevel.LOW);
            setValue(LOGGING_CONSOLELEVEL, LogLevel.HIGH);
            setValue(LOGGING_CHATLEVEL, LogLevel.MED);
        }

        /*** DEBUG ***/
        {
            setValue(DEBUG_SHOWACTIVECHECKS, false);
        }

        /*** MOVING ***/
        {
            setValue(MOVING_CHECK, true);
            setValue(MOVING_IDENTIFYCREATIVEMODE, true);

            setValue(MOVING_RUNFLY_CHECK, true);

            setValue(MOVING_RUNFLY_WALKINGSPEEDLIMIT, 22);
            setValue(MOVING_RUNFLY_SPRINTINGSPEEDLIMIT, 40);
            setValue(MOVING_RUNFLY_JUMPHEIGHT, 135);

            setValue(MOVING_RUNFLY_CHECKSNEAKING, true);
            setValue(MOVING_RUNFLY_SNEAKINGSPEEDLIMIT, 14);

            setValue(MOVING_RUNFLY_CHECKSWIMMING, true);
            setValue(MOVING_RUNFLY_SWIMMINGSPEEDLIMIT, 18);

            ActionList movingActionList = new ActionList();
            movingActionList.setActions(0, action.getActions("moveLogLowShort moveCancel".split(" ")));
            movingActionList.setActions(100, action.getActions("moveLogMedShort moveCancel".split(" ")));
            movingActionList.setActions(400, action.getActions("moveLogHighShort moveCancel".split(" ")));
            setValue(MOVING_RUNFLY_ACTIONS, movingActionList);

            setValue(MOVING_RUNFLY_CHECKNOFALL, true);
            setValue(MOVING_RUNFLY_NOFALLMULTIPLIER, 200);

            ActionList nofallActionList = new ActionList();
            nofallActionList.setActions(0, action.getActions("nofallLog nofallDamage".split(" ")));
            setValue(MOVING_RUNFLY_NOFALLACTIONS, nofallActionList);

            setValue(MOVING_RUNFLY_ALLOWLIMITEDFLYING, false);
            setValue(MOVING_RUNFLY_FLYINGSPEEDLIMITVERTICAL, 100);
            setValue(MOVING_RUNFLY_FLYINGSPEEDLIMITHORIZONTAL, 60);

            ActionList flyingActionList = new ActionList();
            flyingActionList.setActions(0, action.getActions("moveLogLowShort moveCancel".split(" ")));
            flyingActionList.setActions(100, action.getActions("moveLogMedShort moveCancel".split(" ")));
            flyingActionList.setActions(400, action.getActions("moveLogHighShort moveCancel".split(" ")));
            setValue(MOVING_RUNFLY_FLYINGACTIONS, flyingActionList);

            setValue(MOVING_MOREPACKETS_CHECK, true);

            ActionList morepacketsActionList = new ActionList();
            morepacketsActionList.setActions(0, action.getActions("morepacketsLow moveCancel".split(" ")));
            morepacketsActionList.setActions(30, action.getActions("morepacketsMed moveCancel".split(" ")));
            morepacketsActionList.setActions(60, action.getActions("morepacketsHigh moveCancel".split(" ")));
            setValue(MOVING_MOREPACKETS_ACTIONS, morepacketsActionList);

        }

        /*** BLOCKBREAK ***/
        {
            setValue(BLOCKBREAK_CHECK, true);

            setValue(BLOCKBREAK_REACH_CHECK, true);
            setValue(BLOCKBREAK_REACH_LIMIT, 485);

            ActionList reachActionList = new ActionList();
            reachActionList.setActions(0, action.getActions("reachLog blockbreakCancel".split(" ")));
            setValue(BLOCKBREAK_REACH_ACTIONS, reachActionList);

            setValue(BLOCKBREAK_DIRECTION_CHECK, true);

            setValue(BLOCKBREAK_DIRECTION_CHECKINSTABREAKBLOCKS, false);

            ActionList directionActionList = new ActionList();
            directionActionList.setActions(0, action.getActions("directionLog blockbreakCancel".split(" ")));
            setValue(BLOCKBREAK_DIRECTION_ACTIONS, directionActionList);
        }

        /*** BLOCKPLACE ***/
        {
            setValue(BLOCKPLACE_CHECK, true);

            setValue(BLOCKPLACE_REACH_CHECK, true);
            setValue(BLOCKPLACE_REACH_LIMIT, 485);

            ActionList reachActionList = new ActionList();
            reachActionList.setActions(0, action.getActions("reachLog blockplaceCancel".split(" ")));
            setValue(BLOCKPLACE_REACH_ACTIONS, reachActionList);

            setValue(BLOCKPLACE_ONLIQUID_CHECK, true);

            ActionList onliquidActionList = new ActionList();
            onliquidActionList.setActions(0, action.getActions("onliquidLog blockplaceCancel".split(" ")));
            setValue(BLOCKPLACE_ONLIQUID_ACTIONS, onliquidActionList);

        }

        /*** CHAT ***/
        {
            setValue(CHAT_CHECK, true);

            setValue(CHAT_SPAM_CHECK, true);
            setValue(CHAT_SPAM_TIMEFRAME, 5);
            setValue(CHAT_SPAM_LIMIT, 5);

            ActionList spamActionList = new ActionList();
            spamActionList.setActions(0, action.getActions("spamLog spamCancel".split(" ")));
            setValue(CHAT_SPAM_ACTIONS, spamActionList);
        }
    }

    public static void writeActionFile(File file) {
        BufferedWriter w;

        try {
            if(!file.exists()) {
                try {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

            w = new BufferedWriter(new FileWriter(file));

            w(w, "# This file contains the definitions of the default actions of NoCheat.");
            w(w, "# DO NOT EDIT THIS FILE DIRECTLY. If you want to change any of these, copy");
            w(w, "# them to your \"actions.txt\" file and modify them there. If an action with");
            w(w, "# the same name exists here and in your file, yours will be used.");
            w(w, "");
            w.flush();
            w.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeDefaultActionFile(File file) {

        BufferedWriter w;

        try {
            if(!file.exists()) {
                try {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

            w = new BufferedWriter(new FileWriter(file));

            w(w, "# This file contains the definitions of the default actions of NoCheat.");
            w(w, "# DO NOT EDIT THIS FILE DIRECTLY. If you want to change any of these, copy");
            w(w, "# them to your \"actions.txt\" file and modify them there. If an action with");
            w(w, "# the same name exists here and in your file, yours will be used.");
            w(w, "#");
            w(w, "# LOG Actions: They will print messages in your log file, console, chat, ...");
            w(w, "#   - They start with the word 'log'");
            w(w, "#   - Then comes their name. That name is used in the config file to identify them");
            w(w, "#   - Then comes the 'delay', that is how often has this action to be called before it really gets executed");
            w(w, "#   - Then comes the 'repeat', that is how many seconds have to be between two executions of the action");
            w(w, "#   - Then comes the 'loglevel', that is how the log message gets categorized (low, med, high)");
            w(w, "#   - Then comes the 'message', depending on where the action is used, different keywords in [ ] may be used");
            w(w, "");
            w(w, "# Gives a very short log message of the violation, only containing name, violation type and total violation value, at most once every 15 seconds, only if more than 3 violations happened within the last minute (low) and immediatly (med,high)");
            w(w, "log moveLogLowShort 3 15 low NC: [player] failed [check]");
            w(w, "log moveLogMedShort 0 15 med NC: [player] failed [check]");
            w(w, "log moveLogHighShort 0 15 high NC: [player] failed [check]");
            w(w, "");
            w(w, "# Gives a log message of the violation, only containing name, violation type and total violation value, at most once every second, only if more than 5 violations happened within the last minute (low) and immediatly (med,high)");
            w(w, "log morepacketsLow 5 1 low NC: [player] failed [check]: Sent [packets] more packets than expected. Total violation level [violations].");
            w(w, "log morepacketsMed 0 1 med NC: [player] failed [check]: Sent [packets] more packets than expected. Total violation level [violations].");
            w(w, "log morepacketsHigh 0 1 high NC: [player] failed [check]: Sent [packets] more packets than expected. Total violation level [violations].");
            w(w, "");
            w(w, "# Gives a lengthy log message of the violation, containing name, location, violation type and total violation, at most once every 15 seconds, only if more than 3 violations happened within the last minute (low) and immediatly (med,high)");
            w(w, "log moveLogLowLong 3 15 low NC: [player] in [world] at [location] moving to [locationto] over distance [movedistance] failed check [check]. Total violation level so far [violations].");
            w(w, "log moveLogMedLong 0 15 med NC: [player] in [world] at [location] moving to [locationto] over distance [movedistance] failed check [check]. Total violation level so far [violations].");
            w(w, "log moveLogHighLong 0 15 high NC: [player] in [world] at [location] moving to [locationto] over distance [movedistance] failed check [check]. Total violation level so far [violations].");
            w(w, "");
            w(w, "# Some other log messages that are limited a bit by default, to avoid too extreme spam");
            w(w, "log reachLog 0 1 med NC: [player] failed [check]: tried to interact with a block over distance [reachdistance].");
            w(w, "log directionLog 2 1 med NC: [player] failed [check]: tried to destroy a block out of line of sight.");
            w(w, "log onliquidLog 2 1 med NC: [player] failed [check]: tried to place a [blocktype] block at [placelocation] against block at [placeagainst].");
            w(w, "log spamLog 0 4 med NC: [player] failed [check]: Last sent message \"[text]\".");
            w(w, "log nofallLog 0 1 med NC: [player] failed [check]: tried to avoid fall damage for ~[falldistance] blocks.");
            w(w, "");
            w(w, "# SPECIAL Actions: They will do something check dependant, usually cancel an event.");
            w(w, "#   - They start with the word 'special'");
            w(w, "#   - Then comes their name. That name is used in the config file to identify them");
            w(w, "#   - Then comes the 'delay', that is how often has this action to be called before it really gets executed");
            w(w, "#   - Then comes the 'repeat', that is how many seconds have to be between two executions of the action");
            w(w, "#   - Then come further instructions, if necessary");
            w(w, "");
            w(w, "# Cancels the event in case of an violation. Always. No delay. These are equivalent. The different names are just for better readability");
            w(w, "special moveCancel 0 0");
            w(w, "special blockbreakCancel 0 0");
            w(w, "special blockplaceCancel 0 0");
            w(w, "special spamCancel 0 0");
            w(w, "special nofallDamage 0 0");
            w(w, "");
            w(w, "# CONSOLECOMMAND Actions: They will execute a command as if it were typed into the console.");
            w(w, "#   - They start with the word 'consolecommand'");
            w(w, "#   - Then comes their name. That name is used in the config file to identify them");
            w(w, "#   - Then comes the 'delay', that is how often has this action to be called before it really gets executed");
            w(w, "#   - Then comes the 'repeat', that is how many seconds have to be between two executions of the action");
            w(w, "#   - Then comes the command. You can use the same [ ] that you use for log actions. You'll most likely want to use [player] at some point.");
            w(w, "");
            w(w, "# E.g. Kick a player");
            w(w, "consolecommand kick 0 0 kick [player]");
            w.flush();
            w.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void w(BufferedWriter writer, String text) throws IOException {
        writer.write(text);
        writer.newLine();
    }
}
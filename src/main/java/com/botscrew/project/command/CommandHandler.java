package com.botscrew.project.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class CommandHandler {

    private final Map<CommandTemplate, Command> handlers = new HashMap<>();

    public CommandHandler(
            WhoIsHeadOfDepartmentCommand whoIsHeadOfDepartmentCommand,
            ShowStatisticsCommand showStatisticsCommand,
            ShowAverageSalaryCommand showAverageSalaryCommand,
            ShowCountOfEmployeeCommand showCountOfEmployeeCommand,
            GlobalSearchCommand globalSearchCommand) {
        handlers.put(CommandTemplate.WHO_IS_HEAD_OF_DEPARTMENT, whoIsHeadOfDepartmentCommand);
        handlers.put(CommandTemplate.SHOW_STATISTICS, showStatisticsCommand);
        handlers.put(CommandTemplate.SHOW_AVERAGE_SALARY, showAverageSalaryCommand);
        handlers.put(CommandTemplate.SHOW_COUNT_OF_EMPLOYEE, showCountOfEmployeeCommand);
        handlers.put(CommandTemplate.GLOBAL_SEARCH, globalSearchCommand);
    }

    public void handle(String command) {
        try {
            handlers.keySet().stream()
                    .filter(commandTemplate -> isCommandMatchesRegex(command, commandTemplate))
                    .findFirst()
                    .ifPresent(commandTemplate -> handlers.get(commandTemplate).execute(getVariableFromCommand(command, commandTemplate)));
        } catch (Exception e) {
            log.error("Can't execute command! Reason: " + e.getMessage());
        }

    }

    private List<String> getVariableFromCommand(String fullCommand, CommandTemplate template) {
        Pattern pattern = Pattern.compile(template.getRegex());
        Matcher matcher = pattern.matcher(fullCommand);

        List<String> variables = new ArrayList<>();
        int i = 1;
        while (matcher.find()) {
            variables.add(matcher.group(i));
            i++;
        }
        return variables;
    }

    private boolean isCommandMatchesRegex(String command, CommandTemplate template) {
        return command.matches(template.getRegex());
    }
}

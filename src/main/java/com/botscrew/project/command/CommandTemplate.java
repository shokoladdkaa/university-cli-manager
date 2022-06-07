package com.botscrew.project.command;

import lombok.Getter;

@Getter
public enum CommandTemplate {
    WHO_IS_HEAD_OF_DEPARTMENT("^Who\\sis\\shead\\sof\\sdepartment\\s(.*?)$"),
    SHOW_STATISTICS("^Show\\s(.*?)\\sstatistics$"),
    SHOW_AVERAGE_SALARY("^Show\\sthe\\saverage\\ssalary\\sfor\\sthe\\sdepartment\\s(.*?)$"),
    SHOW_COUNT_OF_EMPLOYEE("^Show\\scount\\sof\\semployee\\sfor\\s(.*?)$"),
    GLOBAL_SEARCH("^Global\\ssearch\\sby\\s(.*?)$");

    private final String regex;

    CommandTemplate(String regex) {
        this.regex = regex;
    }
}

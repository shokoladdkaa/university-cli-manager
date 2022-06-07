package com.botscrew.project.command;

import java.util.List;

public interface Command {

    void execute(List<String> variables);
}

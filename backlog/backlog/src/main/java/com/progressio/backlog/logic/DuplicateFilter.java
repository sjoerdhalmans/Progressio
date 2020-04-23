package com.progressio.backlog.logic;

import com.progressio.backlog.models.Backlog;
import com.progressio.backlog.models.Epic;
import com.progressio.backlog.models.Task;
import com.progressio.backlog.models.UserStory;
import javassist.expr.NewArray;

import java.util.ArrayList;
import java.util.List;

public class DuplicateFilter {
    public Backlog filterDuplicates(Backlog backlog) {
        backlog.getLonestories().removeIf(x -> (x.getEpic() != null));
        backlog.getLonetasks().removeIf(x -> (x.getStory() != null));

        return backlog;
    }
}

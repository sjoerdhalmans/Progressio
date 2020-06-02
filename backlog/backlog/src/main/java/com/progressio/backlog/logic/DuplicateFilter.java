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
        for (UserStory story : backlog.getLonestories()) {
            if (story.getEpic() != null && story.getEpic().getId() !=  0) {
                story.setEpicId(story.getEpic().getId());
            }
        }
        backlog.getLonestories().removeIf(x -> (x.getEpic() != null));
        backlog.getLonetasks().removeIf(x -> (x.getStory() != null));

        return backlog;
    }
}

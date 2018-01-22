package dp.school.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by DELL on 22/01/2018.
 */

public class PaymentModel extends ExpandableGroup<Children> {
    private String parenttitle;
    private List<Children> children;

    public PaymentModel(String parenttitle, List<Children> children) {
        super(parenttitle,children);
        this.parenttitle = parenttitle;
        this.children = children;
    }
}

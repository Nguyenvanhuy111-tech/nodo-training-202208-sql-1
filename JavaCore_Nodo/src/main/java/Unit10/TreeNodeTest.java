package Unit10;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();

        TreeNode<String> root = new TreeNode<>("0");

        TreeNode<String>node1 = new TreeNode<>("1.0");
        root.addChild(node1);
        root.addChild(new TreeNode<>("1.1"));
        root.addChild(new TreeNode<>("1.2"));
        root.addChild(new TreeNode<>("1.3"));



        TreeNode<String> node2 = node1.getNextSibling();
        System.out.println("Next sibling of "+node1.getValue()+" is "+node2.getValue());

        node2.addChild("2.0.0");
        node2.addChild("2.1.0");
        node2.addChild("2.1.2");

        TreeNode<String> node3 = node2.getNextSibling();
        System.out.println("Next sibling of " + node2.getValue() + " is " + node3.getValue());

        System.out.println(TreeNodeUtils.contains(root,"2.1.1"));


        list= root.chonloc(v ->{
            return v.contains(".0");
        });

        System.out.println("Co tong so "+list.size()+" chua '.0.'");
        list.forEach(v-> System.out.println("Phan tu loc ===>"+v));
    }
}

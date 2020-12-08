/* In an organization, there are engineers and non-engineers in a hierarchy. And
 * CEO is always the engineer. Remove non-engineers from the hierarchy and
 * return the new hierarchy
 *
 * E.g.       E                              E
 *         /  |   \                        / | \
 *        NE  NE   E     ----->           E  E  E 
 *           /  \  | \                          |
 *          E   NE E NE                         E
 *              |
 *              E
 *
 * Interpretation: This problem can be interpreted as removal of specific nodes 
 * from an N-ary tree. Here the specific nodes are non-engineers.
 *
 * Approach: There are 2 places where NE could show up:
 *           1. leaf  2. non-leaf
 *           if(leaf) -> if(NE) return null else return E
 *           if(non-leaf) -> promote first engineer report
*/
import java.util.*;

class Employee {
    int id;
    List<Employee> reports;
    boolean engineer;
    public Employee(int id, List<Employee> reports, boolean engineer) {
        this.id = id; this.reports = reports; this.engineer = engineer;
    }
}

class RemoveNonEngineers {
    public Employee removeNonEngineers(Employee root) {
        /* if leaf */
        if(root.reports == null || root.reports.isEmpty()) {
            if(root.engineer == false) return null;
            else return root;
        } else {
            /* if non-leaf */
            List<Employee> newReports = new ArrayList<>();
            for(Employee child: root.reports) {
                Employee tmpChild = removeNonEngineers(child);
                if(tmpChild != null) {
                    newReports.add(tmpChild);
                }
            }
            root.reports = newReports;
            //Non engineer and no reports
            if(root.engineer == false && root.reports.isEmpty()) {
                return null;
            } else if(root.engineer == false && !root.reports.isEmpty()) {
                Employee firstEngg = root.reports.get(0);
                //remove first engineer from the parent node's list
                root.reports.remove(firstEngg);
                //make reports of parent node point the reports 
                //of the first engineer
                firstEngg.reports = root.reports;
                root = firstEngg;
                return root;
            } else {
                return root;
            }
        }
    }

    public void printOrg(Employee root) {
        Queue<Employee> bfs = new LinkedList<>();
        bfs.add(root);
        bfs.add(null);
        while(!bfs.isEmpty()) {
            Employee emp = bfs.poll();
            if(emp == null) {
                System.out.println();
                bfs.add(null);
                if(bfs.size() == 1) break;
            } else {
                System.out.print(emp.id + ", ");
                if(emp.reports!=null) {
                    for(Employee child: emp.reports) {
                        bfs.add(child);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 4,5 -> 2
        // 6,7 -> 3
        // 1,2,3 -> 0
        // 8 -> 5
        List<Employee> emps = new ArrayList<>();
        Employee emp4 = new Employee(4, null, true);
        Employee emp8 = new Employee(8, null, true);
        emps.add(emp8);
        Employee emp5 = new Employee(5, emps, false);
        emps = new ArrayList<>();
        emps.add(emp4); emps.add(emp5);
        Employee emp2 = new Employee(2, emps, false);

        emps = new ArrayList<>();
        Employee emp6 = new Employee(6, null, true);
        Employee emp7 = new Employee(7, null, false);
        emps.add(emp6); emps.add(emp7);
        Employee emp3 = new Employee(3, emps, false);

        emps = new ArrayList<>();
        Employee emp1 = new Employee(1, null, true);
        emps.add(emp1); emps.add(emp2); emps.add(emp3);
        Employee ceo = new Employee(0, emps, false);
    
        RemoveNonEngineers rne = new RemoveNonEngineers();
        //rne.printOrg(ceo);
        Employee newOrg = rne.removeNonEngineers(ceo);
        rne.printOrg(newOrg);
    }
}

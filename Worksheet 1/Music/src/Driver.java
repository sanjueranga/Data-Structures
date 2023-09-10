public class Driver {
    public static void main(String[] args) throws Exception {

        Rock rock = new Rock();
        EDM edm = new EDM();
        HipHop hipHop = new HipHop();
        Jazz jazz = new Jazz();
        DeathMetal deathMeatal = new DeathMetal();

        Genere[] generes = { rock, edm, hipHop, jazz, deathMeatal };
        int[] artist_nos = { 1001, 2001, 3001, 4001, 5001, 6001 };

        rock.addWork(1001, 8);
        rock.addWork(2001, 4);
        rock.addWork(3001, 3);

        edm.addWork(2001, 7);
        edm.addWork(3001, 5);
        edm.addWork(1001, 6);

        hipHop.addWork(1001, 5);
        hipHop.addWork(2001, 6);
        hipHop.addWork(4001, 4);

        jazz.addWork(6001, 8);
        jazz.addWork(4001, 6);
        jazz.addWork(5001, 7);

        deathMeatal.addWork(5001, 5);
        deathMeatal.addWork(3001, 7);
        deathMeatal.addWork(6001, 4);

        for (int n : artist_nos) {
            int salary = 0;
            for (Genere g : generes) {
                salary = g.getPayment(n) + salary;

            }
            System.out.println(n);
            System.out.println("Total Salary:" + salary);
        }

    }
}

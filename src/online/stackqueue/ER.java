package online.stackqueue;


import java.util.*;

public class ER {
    static class Patient{
        int order;
        int emergencyRating ;

        public Patient(int order, int emergencyRating) {
            this.order = order;
            this.emergencyRating = emergencyRating;
        }

        public int getEmergencyRating() {
            return emergencyRating;
        }

        public int getOrder() {
            return order;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPatients  = sc.nextInt();
        int patient = sc.nextInt();

        Queue<Patient> orderByArrivalTimeQ = new LinkedList<>();
       // PriorityQueue<Patient> orderByEmergencyRatingQ = new PriorityQueue<>((o1, o2) -> o2.getEmergencyRating()-o1.getEmergencyRating());
       /*PriorityQueue<Patient> orderByEmergencyRatingQ = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                if(o2.getEmergencyRating() == o1.getEmergencyRating()){
                    return o1.getOrder() - o2.getOrder();
                }
                return o2.getEmergencyRating() - o1.getEmergencyRating();
            }
        });*/
        for(int i = 0 ; i < numPatients; i++){
            Patient p = new Patient(i, sc.nextInt());
           orderByArrivalTimeQ.add(p);
            //orderByEmergencyRatingQ.add(p);
        }
        System.out.println(findPatientsTurn(patient, orderByArrivalTimeQ /* orderByEmergencyRatingQ*/));



    }

    static int findPatientsTurn( int patient, Queue<Patient> orderByArrivalTimeQ /*  PriorityQueue<Patient> orderByEmergencyRatingQ*/){
        int count = 1;

       while(!orderByArrivalTimeQ.isEmpty()){
           Patient p = orderByArrivalTimeQ.poll();
           Patient patientInEmergency = null;
           for(Patient p2 : orderByArrivalTimeQ){
               if(p2.getEmergencyRating() > p.getEmergencyRating()){
                   patientInEmergency = p2;
                   orderByArrivalTimeQ.add(p);
                   break;
               }
           }
           if(patientInEmergency == null){
               if(p.getOrder() == patient) return count;
               count++;
           }
        }
        return -1;
    }
}

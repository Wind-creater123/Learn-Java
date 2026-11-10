package Practice;

public class SmartHomeControl {
    private static SmartHomeControl smartHomeControl=new SmartHomeControl();
    private SmartHomeControl() {
    }
    public static SmartHomeControl getInstance() {
        return smartHomeControl;
    }
    public void control(JD jd){
        System.out.println(jd.getName()+" status:"+(jd.isStatus()?"on":"off"));
        System.out.println("SmartHomeControl start");
        jd.switchStatus();
        System.out.println(jd.getName()+" status:"+(jd.isStatus()?"on":"off"));
    }

    public void printAllStatus(JD[] jds) {
        for(int i=0;i<jds.length;i++){
            JD jd=jds[i];
            System.out.println(jd.getName()+" status:"+(jds[i].isStatus()?"on":"off"));
        }
    }
}

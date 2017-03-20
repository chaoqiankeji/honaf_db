package test.buildIn.deprecated;


public class AppleConsumer {
//    @SuppressWarnings({"deprecation"})
    public static void main(String[] args) {
        AppleService appleService=new AppleService();
        appleService.showTaste();
        appleService.showTaste(2);
    }
}

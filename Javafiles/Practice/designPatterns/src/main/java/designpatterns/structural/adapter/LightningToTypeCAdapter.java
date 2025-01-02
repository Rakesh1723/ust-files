package designpatterns.structural.adapter;

public class LightningToTypeCAdapter implements LightningCharger{

    private AndroidPhone androidPhone;

    @Override
    public void chargeWithLightning() {
        System.out.println("LightningToTypeCAdapter");
        androidPhone.charge();
    }

     public LightningToTypeCAdapter(AndroidPhone androidPhone){
         this.androidPhone =androidPhone;
     }
}

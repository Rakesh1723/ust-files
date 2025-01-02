package designpatterns.structural.adapter;

public class Test {
    public static void main(String[] args) {


        IPhone iPhone14 = new IPhone();
//        iPhone14.charge();
        TypeCToLightningAdapter adapter = new TypeCToLightningAdapter(iPhone14);
        adapter.chargeWithTypeC();


        AndroidPhone androidPhone=new AndroidPhone();
     //   androidPhone.charge();
        LightningToTypeCAdapter adapter1=new LightningToTypeCAdapter(androidPhone);
        adapter1.chargeWithLightning();;


    }
}

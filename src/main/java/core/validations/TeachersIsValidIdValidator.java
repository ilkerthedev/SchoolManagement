package core.validations;

import entities.concretes.Students;
import entities.concretes.Teachers;

import java.util.Scanner;

public class TeachersIsValidIdValidator extends IsValidIdValidator {

    Scanner scan = new Scanner(System.in);
    Teachers tch = new Teachers();

    @Override
    public String isValidId(){
        String id = "";
        int flag;
        do {
            flag=0;
            id = scan.next();
            String s = id.replaceAll("[\\d]", "");

            if (!s.isEmpty()){
                System.out.println("Kimlik numarası sayı dışında karakter içeremez!");
                System.out.println("Tekrar deneyiniz: ");
            }else if (id.length()!=11){
                System.out.println("Kimlik numarası 11 rakamdan oluşmalıdır!");
                System.out.println("Tekrar deneyiniz: ");
            }else {
                for (Teachers w:tch.teachersList){
                    if (w.getId().equals(id)){
                        flag++;
                        break;
                    }
                }
                if (flag==0){
                    break;
                }else System.out.println("Bu kimlik numarası zaten kullanımda!"); System.out.println("Tekrar deneyiniz: ");

            }

        }while(true);

        return id;

    }

}

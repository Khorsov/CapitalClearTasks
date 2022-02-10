public class javaTaskToSolve {
    public static  String initialsOfName(String name){
        String initialsOfName = "";
        for(int i=0;i<=name.length()-1;i++){
            char character = name.charAt(i);
            int ascii = (int) character;
            if(ascii>=65&&ascii<=90){   //using ASKII table numbers
                String ww = new Character((char) ascii).toString();
                initialsOfName+=ww+".";
            }
        }
        return initialsOfName;
    }

    public static void main(String[] args) {
        System.out.println(initialsOfName("Bruno Mars Yo"));
        System.out.println(initialsOfName("Bruno Mars"));

    }
}

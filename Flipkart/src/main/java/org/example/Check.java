class Check{
public static void main(String[]ar){
float[] marks = {12.12f,10.31f,56.4f,14.4f,24.34f};
float num = 12.1f;
boolean isInArray = false;
for(float element:marks){
if(num==element){
isInArray = true;
break;
}
}
if (isInArray){
System.out.println("This value is present in the array");
}
else{
System.out.println("This value is not present in the array");
}
}
}

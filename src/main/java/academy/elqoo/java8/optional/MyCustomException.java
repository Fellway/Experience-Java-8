package academy.elqoo.java8.optional;

/**
 * @author sjdmulde
 * Since 20/10/2017.
 */
class MyCustomException extends RuntimeException{
    public MyCustomException(String s){
        super(s);
    }
    public MyCustomException(){
        super();
    }
}

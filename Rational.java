//hw #32 Rational
//max Bertifeld & Sebastian Dittgen team Irrational-rations(dollar-sign)
//APCS pd 10
//11/17/15
public class Rational implements Comparable{
    private int numerator;
    private int denominator;
    public Rational(){
	numerator = 0;
	denominator=1;
    }
    public Rational(int p, int q){
	numerator = p;
	if (q == 0){
	    System.out.println("you git, you can't divide by 0!");//I thought this was very clever, because mr brown told us git is british for idiot
	    numerator = 0;
	    denominator=1;
	}else {
	    denominator = q;
	}
    }
    //Print out the number as a string. 
    public String toString(){
	return "" + ((double)(1.0 * numerator/denominator));}
    //Convert the int/int into a single double
    public float floatValue(){
	return (((float) numerator)/denominator);}
    //change your fraction  into a new fraction while maintaing the multiplier
    public void multiply(Rational r){
	this.numerator = r.numerator * this.numerator;
	this.denominator = r.denominator * this.denominator;}
    //divide your fraction by a new one while maintaing the divisor
    public void divide(Rational r){
	this.numerator = r.denominator * this.numerator;
	this.denominator = r.numerator * this.denominator;}
    //add your fraction to a new one
    public void add(Rational r){
	this.numerator = this.numerator *  r.denominator + this.denominator * r.numerator;
	this.denominator *= r.denominator;
    }
    //subtract a new fraction from your old one
    public void subtract(Rational r){
        this.numerator = this.numerator *  r.denominator - this.denominator * r.numerator;
        this.denominator *= r.denominator;
    }
    //gcd - reused old code, uses Euclid's algorithm
    public  int gcd(Rational r){
        // switch inputs if b > a, because a must be >= b
        int a = r.numerator;
	int b = r.denominator;

	if (b > a){
	    Rational x = new Rational(b,a);
            return gcd(x);
        } else {
            while((a % b) != 0){
                int holder = a; // hold the value of a before it is replaced with b
                a = b;
                b = (holder % b); // b is the original remainder
            }
	    return b;
	}
    }
    //reduce - uses gcd to reduce fraction
    public void reduce(){
	int gcd = gcd(this);
	this.denominator /= gcd;
	this.numerator /= gcd;
    }
    //copied form previos gcd
    public static int gcd( int a, int b){
	//positve and negative numbers are divisible by the same numbers, but for this purpose, lets just use negative
	int mini = Math.abs(Math.min(a,b));//Math methods choose the largest/smallest
	int maxi = Math.abs(Math.max(a,b));
	if (mini == 0 || maxi == 0){/*if its 0 then 0 is divisible by anything
	    , so the biggest number is the answer. if they are both 0 then the
	    answer has to be 0 */
	    return maxi;
	}
	if (maxi % mini == 0) {
	    return mini;
	}else {
	    int newA= mini;//you take the smallest as the new a
	    int newB= maxi%mini;//and the remainder as the new b
	    return gcd(newA, newB);
	}
    }

       public int compareTo( Object other ) {

	if (! ( other instanceof Comparable) ) {
	    throw new ClassCastException ( "\ncompareTo() input not a Hexadecimal");
	}
	if (other == null){
	    throw new NullPointerException ("\ncompareTo() imput is void");
	}
	if (other instanceof Hexadecimal){

	    if (((Hexadecimal)other)._decNum == this.floatValue()){
		return 0;
	    }
	    else if (((Hexadecimal)other)._decNum > this.floatValue()){
		return -1;
	    }
	
	    return 1;}
	if (other instanceof Binary){

	    if (((Binary)other)._decNum == this.floatValue()){
		return 0;
	    }
	    else if (((Binary)other)._decNum > this.floatValue()){
		return -1;
	    }
	    return 1;
	}
	if (other instanceof Rational){

	    if (((Rational)other).floatValue() == this.floatValue()){
		return 0;
	    }
	    else if (((Rational)other).floatValue() > this.floatValue()){
		return -1;
	    }
    
	    return 1;
	}
	return 2;
    }
    


    public static void main(String[] args){
	Rational a = new Rational(1,2);
	Rational b = new Rational(1,4);
	Rational c = new Rational(2,3);
	Rational d = new Rational(4,6);
	
	System.out.println("a= " + a);
	System.out.println("b= " + b);
	System.out.println("c= " + c);
	System.out.println(a.floatValue() + " expecting 0.5");
	a.multiply(c);
	System.out.println(a + " expecting 0.33333");
	a = new Rational(1,2);
	a.divide(c);
	System.out.println(a + " expecting 0.75");
	a = new Rational(1,2);
	a.add(c);
	System.out.println(a + " expecting 1.1666");
        a = new Rational(1,2);
	a.subtract(c);
	System.out.println(a + " expecting -0.1666");
	a = new Rational(1,2);
	System.out.println(a.gcd(b) + " expecting 1");
	a = new Rational(1,2);
	d.reduce();
	System.out.println(d +" expecting .66666");
	System.out.println(a.compareTo(b) + " expecting 1");
    }

}// end Rational

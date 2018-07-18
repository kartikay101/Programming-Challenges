/**
 * @Author: Kartikay Shandil <kartikay101>
 * @Date:   2018-07-18T13:47:59+05:30
 * @Last modified by:   kartikay101
 * @Last modified time: 2018-07-18T14:07:01+05:30
 */

import java.util.*;

class fizzbuzz{
	public static void main(String args[]){

		Scanner sc=new Scanner(System.in);

		int T;
		T=sc.nextInt();

		for(int tc=0;tc<T;tc++){

			int a,b,c;

			a=sc.nextInt();
			b=sc.nextInt();
			c=sc.nextInt();

			for(int i=1;i<=c;i++){

				if(i%a==0&&i%b==0){
					System.out.println("FizzBuzz");
				}
				else if(i%a==0){
					System.out.println("Fizz");
				}
				else if(i%b==0){
					System.out.println("Buzz");
				}
				else{
					System.out.println(i);
				}
			}
		}
	}
}

#include <avr/io.h>
#include <stdio.h>
#include <stdint.h>
#include <util/delay.h>

/*
Evidence of C code skills. Program to interact with a ATMega328p microcontroller. 
Finds all prime numbers up to 300 and transmits them to microcontroller.
*/

int isPrime(int n){
	for(int j = 2; j < n; j++){
		// if there are factors of n, return false
		if(n%j == 0){
			return 0;
		}
	}
	// if no factors, return true
	return 1;
}

void usart_init(uint8_t ubrr)
{
	//UBRR0H = (unsigned char) (ubrr>>8);
	//UBRR0L = (unsigned char) (ubrr);
	UBRR0 = 12;
	//UCSR0A |=(1 << TXC0);
	//UCSR0B |=(1 << RXEN0);
	UCSR0B |=(1 << TXEN0);
}

void usart_transmit(uint8_t data)
{
	while ((UCSR0A & 0b00100000) == 0){       //UDRE0 bit is checked to see if it is 0
		;                                         //If UDRE0 bit is not 0, wait until it becomes 0
	}
	UDR0 = 55;
}

int main(void)
{
	int primes[62];
	int j = 0;
	for(int i = 2; i < 300; i++){
		// find all prime numbers up to 300
		if(isPrime(i) == 1)
			primes[j] = i;
			j++;
		}
	}
	/*
    // print all prime numbers
	for(int k = 0; k < 62; k++){
		printf("%i ", primes[k]);
	}
    */
	
	// initialize micro-controller
	usart_init(12);
	
	while(1)
	{
		//add time delay of 0.5s
		_delay_ms(500);
		for(int m = 0; m < 62; m++)
        {
            // send through all prime numbers digit by digit
            int hundreds = primes[m]%100;
            primes[m] -= hundreds;
            int tens = primes[m] % 10;
            primes[m] -= tens;

            usart_transmit(hundreds);
            usart_transmit(tens);
            usart_transmit(primes[m]);
        }
		
	}
	return 0;
}
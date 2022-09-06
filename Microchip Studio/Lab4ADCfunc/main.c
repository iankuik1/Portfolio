/*
 * Lab4ADCfunc.c
 *
 * Created: 30/08/2022 3:37:36 pm
 * Author : ikui753
 */ 

#include <avr/io.h>
#include <stdio.h>

void adc_init()
{
	// initialize ADC control registers
	ADMUX = 0b00000010;
	ADCSRA = 0b10101101;
	ADCSRB = 0B00000000;
}

uint16_t adc_read(uint16_t channel)
{
	switch (channel)
	{
		case 0:
		ADMUX =  0b00000000;
		break;
		
		case 1:
		ADMUX =  0b00000001;
		break;
		
		case 2:
		ADMUX =  0b00000010;
		break;
		
		case 3:
		ADMUX =  0b00000011;
		break;
		
		case 4:
		ADMUX =  0b00000100;
		break;
		
		case 5:
		ADMUX =  0b00000101;
		break;
		
		case 6:
		ADMUX =  0b00000110;
		break;
		
		case 7:
		ADMUX =  0b00000111;
		break;
		
		default:
		return 0;
	}
	// assume channel is 2
	ADCSRA |= (1<<ADSC); // start adc conversion
	while (ADCSRA & (1<<ADSC)); // wait for conversion to finish
	uint8_t adcl = ADCL;
	uint8_t adch = ADCH;
	return adcl | (adch << 8);
}

// convert adc to mv
uint16_t adc_convert_mv(uint16_t value)
{
	float vres = ((float) 5 / 1024) * value;
	return vres * 1000;
}

// convert mV to ascii
void mVtoAscii(uint16_t mV)
{
	// get each digit
	uint16_t digits[4];
	digits[0] = ((mV/1000)%10) + 48; // thousands
	digits[1] = ((mV/100)%10) + 48; // hundreds
	digits[2] = ((mV/10)%10) + 48; // tens
	digits[3] = (mV%10) + 48; // ones
	
	// send through digits followed by _,
	usart_transmit(digits[0]);
	usart_transmit(digits[1]);
	usart_transmit(digits[2]);
	usart_transmit(digits[3]);
	usart_transmit(',');
	usart_transmit(' ');
}

// transmit function
void usart_transmit(uint8_t data)
{
	while ((UCSR0A & 0b00100000) == 0){       //UDRE0 bit is checked to see if it is 0
		;                                         //If UDRE0 bit is not 0, wait until it becomes 0
	}
	UDR0 = data;
}

void usart_init(uint8_t ubrr)
{
	UBRR0H = (unsigned char) (ubrr>>8);
	UBRR0L = (unsigned char) (ubrr);
	UBRR0 = 12;
	UCSR0A |=(1 << TXC0);
	UCSR0B |=(1 << TXEN0) | (1 << UCSZ02);
}

int main(void)
{
	adc_init();
	usart_init(12);
	
	uint8_t adc1[40];
	uint8_t adc2[40];
	
    while (1)
    {
		
		mVtoAscii(adc_read(0));
		mVtoAscii(adc_read(1));
	}
}


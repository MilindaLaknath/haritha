#define trig 3
#define echo 4 
int value;
void setup() {
  // put your setup code here, to run once:
pinMode(trig,OUTPUT);
pinMode(echo,INPUT);
pinMode(13,OUTPUT);
Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(trig,LOW);
  delayMicroseconds(2);
  digitalWrite(trig,HIGH);
  delayMicroseconds(10);
  digitalWrite(trig,LOW);
  long t1 = pulseIn(echo,HIGH);

   long cm1 = t1/29/2;
//
//Serial.println(cm1);

if(cm1 < 8)
      {
        delay(4000);
        digitalWrite(trig,LOW);
        delayMicroseconds(2);
        digitalWrite(trig,HIGH);
        delayMicroseconds(10);
        digitalWrite(trig,LOW);
        long t2 = pulseIn(echo,HIGH);
        long cm2 = t2/29/2;
              if(cm2 < 8)
                  {
                    value=1;
                    digitalWrite(13,HIGH);
                    Serial.println(value);

                    }
              else
                  {
                    value=0;
                    Serial.println(value);
                    }
      }
else
    {
      digitalWrite(13,LOW);
      value=0;
      Serial.println(value);
      }
      delay(1000);
}

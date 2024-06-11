#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>
#include <Wire.h>

#define DHTPIN 6         // DHT11 sensor data pin
#define DHTTYPE DHT11    // DHT sensor type

#define MOTOR_PIN_ENB 9  // Enable pin for motor driver (PWM pin)
#define MOTOR_PIN_IN3 10  // Input pin 1 for motor driver

double TEMPERATURE_THRESHOLD = 28;
double TEMPERATURE_THRESHOLD1 = 36;
int power = 1;

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(115200);
  dht.begin();
  Wire.begin();
  pinMode(DHTPIN, INPUT);
  pinMode(MOTOR_PIN_ENB, OUTPUT);
  pinMode(MOTOR_PIN_IN3, OUTPUT);
}

float prevTemp = -1;

void adjustFanSpeed(int speed){
  analogWrite(MOTOR_PIN_ENB, speed);
}

void ReadSerialTagAndData(){
  if(Serial.available() > 0){
    power = Serial.readStringUntil(';').toInt();
    TEMPERATURE_THRESHOLD = Serial.readStringUntil(';').toDouble();
    TEMPERATURE_THRESHOLD1 = Serial.readStringUntil('-').toDouble();
    Serial.readStringUntil('\n');
  }
}

void loop() {
  delay(1000);
  float temperature = dht.readTemperature();
  if (isnan(temperature)) {
    prevTemp = -1;
    // Serial.println(-1);
    // return;
  }

  if(temperature != prevTemp){
    prevTemp = temperature;
    // Serial.print("Temperature: ");
    if(!isnan(temperature))
      Serial.println(temperature);
    // Serial.println(" °C");
  }

  ReadSerialTagAndData();
  // Serial.println(power);
  // Serial.println(TEMPERATURE_THRESHOLD);
  // Serial.println(TEMPERATURE_THRESHOLD1);
  if(power == 0){
    digitalWrite(MOTOR_PIN_IN3, LOW);
  }else{
    digitalWrite(MOTOR_PIN_IN3, HIGH);
  }

  if (temperature > TEMPERATURE_THRESHOLD1){
    adjustFanSpeed(255);
  }else if(temperature > TEMPERATURE_THRESHOLD){
    adjustFanSpeed(200);
  }else{
    adjustFanSpeed(150);
  }
}

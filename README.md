# Bicycle_server

Pricing Engine Application
Bicycle consists of components
             1. frame
             2. handle bar with brakes
             3. seating,
             4. wheels,
             5. chain assembly
             
Tto calculate the price of the cycle given its configuration. 
For example, price a cycle with tubeless tyres, steel frame, 4 gears. The pricing of the parts is time
sensitive, means the cost of a tyre will change with time and the module should support this. A tyre
can cost 200Rs from Jan 2016 - Nov 2016, and its price can change to Rs 230 from Dec 2016
onwards.      


Steps to excute: 
1) Go through the "PricingEngine/src/main/resources/input/bicycle.json" file first and you can copy to your local desired loaction.
2) specify the path of input bicycle.json file in PriceEngineUtil.java ("PricingEngine/src/main/java/com/benchire/pricingengine/util/PriceEngineUtil.java") filePath.
3) Run PricingEngineApplication to get output and output json files will be stored in the file path directory as OUTPUT_Bicycle.json files.
4) Kindly go through the comment block which helps in understanding of logic.
             
             

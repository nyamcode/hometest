# hometest

The details of the test are specified below, please submit the your work no later than EOD Wednesday, 7/25 using any language of your choice. What you submit can be in any editor you prefer to use. Please try to spend no more than an hour on the test. We look forward to your submission. 

Attached is a CSV formatted data for wages in the city of Seattle (src/main/resources/City_of_Seattle_Wage_Data.csv).
 
Given this file please write a script that produces json formatted output that identifies the highest average paying job title along with the department for all unique first names. Please ignore Sr and roman numerals (like II, III). Please try to spend only about an hour for this exercise.

For example if we have : 

 

Department	Last Name	First Name	Job Title	Hourly Rate
QA	Stargel	Eric	QA Engineer	35
QA	Miller	Eric	QA Engineer Sr	40
 

We want the output to be : 

{
   "Eric": {
      "Department": "QA",
      "Job Title": "QA Engineer",
      "Average Hourly Rate": "37.5"
     }
}

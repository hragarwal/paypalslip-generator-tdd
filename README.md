# Employee monthly pay slip generator

## Technology Stack :
  - Java8
  - Maven
  - JUnit
  - Intellij
  - Test Driven Development Approach

## Assumptions :
  - Reading csv as a string rather then using any library. Also, considering the sequence would be fixed.

## Code Coverage :
  - Test coverage is 100%

## Architecture / Design :
  - Added Builder pattern for all the models including small & large to make it consistent (As an example Employee class doesn't need builder pattern as it contains just two fields but added it to be consistent with other models).
  - PayslipGenerator is responsible for generating the incometax, netincome & super from annual salary.
  - Final response is returned as Payslip object which is used to write data in csv format.
  - CsvReader & CsvWriter are used to read & write data from csv.
  - Added class hierarchy for Income Tax calculation, below are the details
  - IncomeTaxTable: Contains list of income tax slabs
  - IncomeTaxSlab: Contains a single slab which consists of IncomeTaxBracket & IncomeTaxThreshold
  - IncomeTaxBracket: It contains min & max salary range in the bracket
  - IncomeTaxThreshold: It contains default tax, marginal tax & income threshold
        
    

## How to use API
  - Please find HowToUse.java for more details.
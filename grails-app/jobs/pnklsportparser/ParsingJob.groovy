package pnklsportparser

    
class ParsingJob {
    
    ParserService parserService

    static triggers = {
        simple startDelay: 5000, repeatInterval: 30000
    }
    
    def execute() {
      println "Run ParsingJob!" 
      def DV = DefaultValue.findByName("PINNACLESPORTSROBOT")
      if (DV.parserTurn == "on"){
            def unixTime = new Date().getTime()
            def diffTime = 0
            
            
            if (DV.lastAutoRun){
                diffTime = unixTime - DV.lastAutoRun.getTime()
                if(diffTime >= DV.parserTerm*1000){
                    println "Start parsing proccess..."
                    parserService.runParsing("auto")
                    
               
                    
                    println "Stop parsing proccess." 
                }
            } else {
                println "Start parsing proccess..."
                parserService.runParsing("auto")
                println "Stop parsing proccess." 
            } 
      }
    }

}


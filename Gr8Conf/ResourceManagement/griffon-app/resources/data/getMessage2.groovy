//results.found = {0} results of {1} found
getMessage("results.found", [2, 5])

//results.found = {0} results of {1} found
getMessage("results.found", [_0: 2, _1: 5])

//results.found = {actual} results of {all} found
getMessage("results.found", [actual: 2, all: 5])

//results.found = #0 results of #1 found
getMessage("results.found", [2, 5])

//message.today = Today is: #{date.format('yyyy/MM/dd')}
getMessage("message.today", [date: new Date()])
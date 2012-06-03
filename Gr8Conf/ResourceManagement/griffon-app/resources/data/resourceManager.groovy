assert rm.application.title == "My Demo Application"
assert rm[Locale.GERMAN].application.title == "Meine Demo Anwendung"
assert rm.unknown.key ?: 'No value' == "No value"
// list.data = ['cherries', 'pears', 'oranges']
List data = rm.list.data
//results.found = '{0} results of {1} found'
assert rm.results.found([2, 5]) == '2 results of 5 found'
//results.found = {actual} results of {all} found
assert rm.results.found(actual: 2, all: 5) == '2 results of 5 found'
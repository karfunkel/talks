ConfigParser parser = new ConfigParser()
ConfigNode node = parser.parse '''
key1 = { 'Normal Closure' }
key2 = { new Date() } as ConfigFactory
key3 = { new Date() } as ConfigLazy
'''

println node.key1() // Normal Closure

println node.key2   // Sun Jun 03 12:35:36 CEST 2012
sleep 1000
println node.key2   // Sun Jun 03 12:35:37 CEST 2012
sleep 1000

println node.key3   // Sun Jun 03 12:35:38 CEST 2012
sleep 1000
println node.key3   // Sun Jun 03 12:35:38 CEST 2012
sleep 1000
println node.key3   // Sun Jun 03 12:35:39 CEST 2012
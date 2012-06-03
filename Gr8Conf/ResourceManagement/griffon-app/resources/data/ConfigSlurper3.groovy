def root = slurper.parse '''
group('groupValue') {
    child = 'childValue'
}
group2 = 'groupValue'
group2.child = 'childValue' // Fails: No property child on String
group3.child = 'childValue'
group3 = 'groupValue'   '''
assert root.group == 'groupValue'
assert root.'group.child' == 'childValue'
assert root.group3 == 'groupValue'
assert root.'group3.child' == 'childValue' // Fails: No property child on String
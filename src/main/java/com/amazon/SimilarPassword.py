# https://leetcode.com/discuss/interview-question/2439597/Amazon-OA-2023

def matchingChar(new_char, old_char): 
    ord_new_char = ord(new_char)
    ord_old_char = ord(old_char)
    if ord_new_char == ord_old_char: return True
    if ord_new_char + 1 == ord_old_char: return True
    if ord_new_char == ord('z') and ord_old_char == ord('a'): return True

def checkPasswords(new_pw, old_pw):
    if len(new_pw) < len(old_pw): return "NO"
    new_pw_ptr = 0
    num_match = 0
    for old_char in old_pw:
        match_found = False
        for i in range(new_pw_ptr, len(new_pw)):
            new_char = new_pw[i]
            match_found = matchingChar(new_char, old_char)
            if match_found:
                num_match += 1
                new_pw_ptr = i + 1
                break
        if not match_found: return "NO"
    
    if num_match != len(old_pw): return "NO"
    return "YES"

def checkSimilarPasswords(new_passwords, old_passwords):
    result = []
    for new_pw in new_passwords:
        for old_pw in old_passwords:
              result.append(new_pw + ", " + old_pw + ": " + checkPasswords(new_pw, old_pw)) # easier for test checking. can just append checkPasswords(new_pw, old_pw)
    return result

# Test Cases:

new_pws = ['baacbab', 'accdb', 'baacba']
old_pws = ['abdbc', 'ach', 'abb']

print(checkSimilarPasswords(new_pws, old_pws)) 
# Result: ['baacbab, abdbc: YES', 'baacbab, ach: NO', 'baacbab, abb: YES', 'accdb, abdbc: NO', 'accdb, ach: NO', 'accdb, abb: NO', 'baacba, abdbc: NO', 'baacba, ach: NO', 'baacba, abb: YES']

# Should be NO b/c new_pw is too short to be subseq
new_pws = ['aaa']
old_pws = ['bbbb']

print(checkSimilarPasswords(new_pws, old_pws))
# Result: ['aaa, bbbb: NO']

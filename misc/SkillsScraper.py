import time
import selenium
from selenium import webdriver
from selenium.webdriver import Chrome
from selenium.webdriver.common.by import By

# Rough python script I've put together to scrape one of the Hiring website
# to check the hot skills which recruiters are looking for in candidates
#
# This is basic version, can be improved

browser = webdriver.Chrome()

iter = 1
types = {}
sortedSkills = {}

while iter < 50:
    url = 'https://www.naukri.com/senior-software-developer-java-jobs'
    +('' if iter == 1 else str(-iter))
    +'?k=senior%20software%20developer%2C%20java'

    print("checking url : ",url)
    browser.get(url)
    time.sleep(2)
    tags = browser.find_elements(By.CLASS_NAME, value='tags')
    for tag in tags:
        tagVal = tag.text
        for skill in tagVal.split("\n"):
            if skill not in types:
                types[skill] = 0
            types[skill] += 1
    iter+=1

sortedSkills = dict(sorted(types.items(),key = lambda x:x[1], reverse = True))

for k,v in sortedSkills.items():
    print(k," is referred ",v," times")
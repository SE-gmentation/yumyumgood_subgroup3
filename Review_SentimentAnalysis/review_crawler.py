from selenium import webdriver
import time

file_name = 'restaurant_review'

url_front = "https://pcmap.place.naver.com/restaurant/"
url_back = "/review/visitor"

restaurant_list = [13575119, 36406716, 13574931, 18714649, 1728322688, 19769179, 1003725520, 36208511, 36183674, 12890044, 11819292, 36813148, 37221619, 11679660]
contents = []
driver = webdriver.Chrome('./chromedriver')

f = open(f'{file_name}.txt', 'w')

for restaurant in restaurant_list:
    driver.implicitly_wait(5)
    driver.get(url_front + str(restaurant) + url_back)
    while True:
        try:
            more = driver.find_element_by_class_name("_3iTUo")
            more.click()
            time.sleep(2)
        except:
            break

    scores = driver.find_elements_by_class_name("_2tObC")
    reviews = driver.find_elements_by_class_name("WoYOw")
    scores = map(lambda x: x.text, scores)
    reviews = map(lambda x: x.text, reviews)
    contents.append(list(zip(scores, reviews)))


for content in contents:
    for score, review in content:
        f.write(f"{score}\t{review}\n")

f.close()
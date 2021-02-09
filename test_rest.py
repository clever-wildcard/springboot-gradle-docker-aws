"""
$ python3 path/to/test_rest.py
"""
import requests


def test_request(console_message, method, uri, request_body={}):
    print(console_message)
    response = requests_dot_method(method, uri, request_body)
    print(response.status_code)
    print(response.headers)
    print(response.json())
    print()
    return response


def requests_dot_method(method, uri, request_body={}):
    if method == 'post':
        return requests.post(uri, json=request_body)
    if method == 'get':
        return requests.get(uri)
    if method == 'put':
        return requests.put(uri, json=request_body)
    if method == 'delete':
        return requests.delete(uri)


response = test_request("Response from testing the creation of an employee: ",
                        'post',
                        "http://annaofalltrades.com/employees",
                        {'name': 'Anna Soto', 'role': 'Software Engineer'})
newest_id = response.json()['id']

test_request("Response from testing the getting of all employees:",
             'get',
             "http://annaofalltrades.com/employees")

test_request("Response from requesting an id that does not exist:",
             'get',
             "http://annaofalltrades.com/employees/999999")

test_request("Response from requesting an id that does exist:",
             'get',
             "http://annaofalltrades.com/employees/{}".format(newest_id))

test_request("Response from testing the replacing of an employee",
             'put',
             "http://annaofalltrades.com/employees/replace/{}".format(newest_id),
             {"name": "Curious the Cat", "role": "Companion"})

test_request("Response from testing the deletion of an employee",
             'delete',
             "http://annaofalltrades.com/employees/{}".format(newest_id))

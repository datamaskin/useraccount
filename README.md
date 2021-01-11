## Feature tomcat-server documentation

- [Micronaut Tomcat Server documentation](https://micronaut-projects.github.io/micronaut-servlet/1.0.x/guide/index.html#tomcat)

# Fetch Rewards Coding Exercise - Backend Software Engineering

## What do I need to submit?

Please write a web service that accepts http requests and returns responses based on the condition outlined in the next section.

You can use any language and frameworks you choose.

We must be able to run your web service; provide any documentation necessary to accomplish this as part of the repository you submit.

Please assume the user has not executed an application in your language/framework before when developing your documentation.

## What does it needs to do?

```
Background
```
Our users have points in their accounts. Users only see a single balance in their accounts. But for reporting purposes we actually track their
points per payer/partner. In our system, each transaction record contains: payer name(string), points (integer), transactionDate (Date).

For earning points it is easy to assign a payer, we know which actions earned the points. And thus which partner should be paying for the points.

When a user spends points, they don't know or care which payer the points come from. But, our accounting team does care how the points are
spent. There are two rules for determining what points to "spend" first:

We want the oldest points to be spent first
We want no payer's points to go negative.

```
We expect your web service to
```
Provide routes that:

```
Add points to user account for specific payer and date
Deduct points from the user account using above constraints and return a list of [payer, points deducted] for each call to spend points
Return point balance per user that would list all positive points per payer
```
Note we are not defining specific requests/responses. Defining these are part of the exercise.

We don’t expect you to use any durable data store. Please store all transaction information in the service memory.

```
Example
```
Suppose you call your add points route with the following sequence of calls:
add [DANNON, 300 points, 10/31 10AM] to user
add [UNILEVER, 200 points, 10/31 11AM] to user
add [DANNON, -200 points, 10/31 3PM] to user
add [MILLER COORS, 10,000 points , 11/1 2PM] to user
add [DANNON, 1000 points 11/2 2PM] to user

Example client:
`curl -X GET http://localhost:8080/balance/add/MILLER+COORS/10000/11/1+2PM`

Then you call your deduct points route with the following request:

deduct 5000 points from user

Example client: `curl -X GET http://localhost:8080/balance/deduct/DANNON/200/`

The expected response from the deduct call would be:

[DANNON, -100 points, now],
[UNILEVER, -200 points, now],
[MILLER COORS, -4,700 points, now]

A subsequent query to the points balance route, after the deduction, should returns the following results:
DANNON, 1000 points
UNILEVER, 0 points
MILLER COORS, 5,300 points

Example client: `curl -X GET http://localhost:8080/balance`

## How do I submit it?


Provide a link to a public repository, such as GitHub or BitBucket, that contains your code to your recruiter.

## FAQ

```
How will this exercise be evaluated?
```
An engineer will review the code you submit. At a minimum they must be able to run the service and the service must provide the expected
results. You should provide any necessary documentation within the repository. While your solution does not need to be fully production ready,
you are being evaluated so put your best foot forward.

```
I have questions about the problem statement
```
For any requirements not specified via an example, use your best judgement to determine expected result.

```
Can I provide a private repository?
```
If at all possible, we prefer a public repository because we do not know which engineer will be evaluating your submission. Providing a public
repository ensures a speedy review of your submission. If you are still uncomfortable providing a public repository, you can work with your
recruiter to provide access to the reviewing engineer.

```
How long do I have to complete the exercise?
```
There is no time limit for the exercise. Out of respect for your time, we designed this exercise with the intent that it should take you a few hours.
But, please take as much time as you need to complete the work.



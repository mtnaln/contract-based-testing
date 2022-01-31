package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "get course by id == 1"

    request {
        url "/courses/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                "id": 1,
                "name": "Java",
                "must": true
        )
    }
}
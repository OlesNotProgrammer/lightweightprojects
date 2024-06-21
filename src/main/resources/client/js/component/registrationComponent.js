const RegistrationComponent = (() => {
    const buildFunction = () => {
        return createStructure(
            createBlock("div", ["class", "container-fluid d-flex justify-content-center align-items-center"]),
            createStructure(
                createBlock("main", ["class", "app__form-container border rounded shadow px-4 py-3"]),
                createElement("h2", "Registration", ["class", "fs-2 my-5 text-center"]),
                createStructure(
                    createBlock("div", ["class", "row mb-3"]),
                    createElement("label", "Email", ["class", "col-2 col-form-label"]),
                    createStructure(
                        createBlock("div", ["class", "col-10"]),
                        createBlock("input", ["class", "form-control"], ["type", "text"], ["id", "registration-email"])
                    )
                ),
                createStructure(
                    createBlock("div", ["class", "row mb-3"]),
                    createElement("label", "Login", ["class", "col-2 col-form-label"]),
                    createStructure(
                        createBlock("div", ["class", "col-10"]),
                        createBlock("input", ["class", "form-control"], ["type", "text"], ["id", "registration-login"])
                    )
                ),
                createStructure(
                    createBlock("div", ["class", "row mb-3"]),
                    createElement("label", "Password", ["class", "col-2 col-form-label"]),
                    createStructure(
                        createBlock("div", ["class", "col-10"]),
                        createBlock("input", ["class", "form-control"], ["type", "password"], ["id", "registration-password"])
                    )
                ),
                createStructure(
                    createBlock("div", ["class", "d-flex justify-content-between mt-5"]),
                    createElement("p", "<a href='#' data-authorization-trigger>Already have an account?</a>", ["class", "form-text"]),
                    createElement("button", "Submit", ["class", "btn btn-primary"], ["id", "registration-submit"])
                )
            )
        );
    };

    const handleFunction = () => {
        select("[data-authorization-trigger]").onclick = 
            event => AuthorizationComponent.build();

        select("#registration-submit").onclick = event => {
            register({
                "login": select("#registration-email").value,
                "password": select("#registration-login").value,
                "email": select("#registration-password").value,
                "registrationDate": new Date()
            });
        };
    };
    
    const destroyFunction = () => {
        
    };

    return new Component(buildFunction, handleFunction, destroyFunction);
})()

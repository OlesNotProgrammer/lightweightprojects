const AuthorizationComponent = (() => {
    const buildFunction = () => {
        return createStructure(
            createBlock("div", ["class", "container-fluid d-flex justify-content-center align-items-center"]),
            createStructure(
                createBlock("main", ["class", "app__form-container border rounded shadow px-4 py-3"]),
                createElement("h2", "Authorization", ["class", "fs-2 my-5 text-center"]),
                createStructure(
                    createBlock("div", ["class", "row mb-3"]),
                    createElement("label", "Email", ["class", "col-2 col-form-label"]),
                    createStructure(
                        createBlock("div", ["class", "col-10"]),
                        createBlock("input", ["class", "form-control"], ["type", "text"], ["id", "authorization-email"])
                    )
                ),
                createStructure(
                    createBlock("div", ["class", "row mb-3"]),
                    createElement("label", "Password", ["class", "col-2 col-form-label"]),
                    createStructure(
                        createBlock("div", ["class", "col-10"]),
                        createBlock("input", ["class", "form-control"], ["type", "password"], ["id", "authorization-password"])
                    )
                ),
                createStructure(
                    createBlock("div", ["class", "d-flex justify-content-between mt-5"]),
                    createElement("p", "Need an account? <a href='#' data-registration-trigger>Registration</a>", ["class", "form-text"]),
                    createElement("button", "Submit", ["class", "btn btn-primary"], ["id", "authorization-submit"])
                )
            )
        );
    };

    const handleFunction = () => {
        document.querySelector("[data-registration-trigger]").onclick = 
            event => RegistrationComponent.build();
    };
    
    const destroyFunction = () => {
        
    };

    return new Component(buildFunction, handleFunction, destroyFunction);
})();

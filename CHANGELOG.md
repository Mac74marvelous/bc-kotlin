# Changelog

## 0.1.0-alpha.1 (2025-08-22)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/Mac74marvelous/bc-kotlin/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### Features

* add retryable exception ([8caf699](https://github.com/Mac74marvelous/bc-kotlin/commit/8caf6995cc913f36d3f93f32590610f42867cade))
* **client:** add `{QueryParams,Headers}#put(String, JsonValue)` methods ([b0ffd70](https://github.com/Mac74marvelous/bc-kotlin/commit/b0ffd7085b9c416e2f25761fdd8bffe58e4d0179))
* **client:** add https config options ([2006696](https://github.com/Mac74marvelous/bc-kotlin/commit/2006696f39f1adc7644b92111952978b22bf8ebe))
* **client:** allow configuring env via system properties ([dfae9b9](https://github.com/Mac74marvelous/bc-kotlin/commit/dfae9b9b8bd9a0c23483d4829585c4be09dd7bec))
* **client:** ensure compat with proguard ([d14e88b](https://github.com/Mac74marvelous/bc-kotlin/commit/d14e88b958a8e733fe0e701d832dd8d6dcd00b95))


### Bug Fixes

* **client:** ensure error handling always occurs ([79ea59a](https://github.com/Mac74marvelous/bc-kotlin/commit/79ea59a14a81d09291a0440c0d208f0a0ebe4d8b))
* **client:** r8 support ([e0cb038](https://github.com/Mac74marvelous/bc-kotlin/commit/e0cb038671b7aca227f2206c59d7a06bae615487))
* **internal:** set maven publish url ([23782da](https://github.com/Mac74marvelous/bc-kotlin/commit/23782dadee0818543e0312b3e11883b3f4e5a1c6))


### Performance Improvements

* **internal:** make formatting faster ([08df60b](https://github.com/Mac74marvelous/bc-kotlin/commit/08df60b9d4a66709af0c2bb5c0345ec3ef2c9b34))


### Chores

* **ci:** add build job ([76b5120](https://github.com/Mac74marvelous/bc-kotlin/commit/76b5120b3f22f6f4af72b84b531a5c5fac2e8a15))
* **ci:** bump `actions/setup-java` to v4 ([5d9fadf](https://github.com/Mac74marvelous/bc-kotlin/commit/5d9fadf42c5281167561a4d8deb60ce0206ebb0d))
* **ci:** reduce log noise ([baa0a3f](https://github.com/Mac74marvelous/bc-kotlin/commit/baa0a3f5bf19b4070c0442b593de25c67dd275b5))
* **client:** refactor closing / shutdown ([b89b172](https://github.com/Mac74marvelous/bc-kotlin/commit/b89b172c62edb1ea33f7ba29fa2cca8e04353f8f))
* **example:** fix run example comment ([d6bbbdd](https://github.com/Mac74marvelous/bc-kotlin/commit/d6bbbdd443fad4d237efe2c717186846637da5eb))
* increase max gradle JVM heap to 8GB ([bc40d1c](https://github.com/Mac74marvelous/bc-kotlin/commit/bc40d1c0c5939a6f809affcc18c476fdcf59f971))
* **internal:** add async lock helper ([8af56ec](https://github.com/Mac74marvelous/bc-kotlin/commit/8af56ecebea2f2b6188fe1a12dc53a52c64c0ce9))
* **internal:** allow running specific example from cli ([ba6b70d](https://github.com/Mac74marvelous/bc-kotlin/commit/ba6b70d8bb653c091754cdea1f34b8853169212b))
* **internal:** bump ci test timeout ([4d4c95d](https://github.com/Mac74marvelous/bc-kotlin/commit/4d4c95dcd555787d6183ffd9c458d6858715ef54))
* **internal:** codegen related update ([0df2678](https://github.com/Mac74marvelous/bc-kotlin/commit/0df2678d788a5c25e2896b062d3110c7ff46d98e))
* **internal:** codegen related update ([9cf7f52](https://github.com/Mac74marvelous/bc-kotlin/commit/9cf7f523526de856f2cd2dbe2bce605d3b6b47ee))
* **internal:** codegen related update ([bb63890](https://github.com/Mac74marvelous/bc-kotlin/commit/bb638906b76182d3ed8af7034501d6eb733c9e27))
* **internal:** dynamically determine included projects ([7e11dea](https://github.com/Mac74marvelous/bc-kotlin/commit/7e11dead0e7a1587fa1f435d7199391e54a2a095))
* **internal:** reduce proguard ci logging ([7c57ceb](https://github.com/Mac74marvelous/bc-kotlin/commit/7c57ceb11ba878ab6d5511cda14140a416cf11bc))
* **internal:** refactor delegating from client to options ([32096f5](https://github.com/Mac74marvelous/bc-kotlin/commit/32096f578a75a0d39458518c9f25ba11475081fe))
* **internal:** remove unnecessary `[...]` in `[@see](https://github.com/see)` ([26fc92a](https://github.com/Mac74marvelous/bc-kotlin/commit/26fc92a74aa59ad5a4fff37d208add92847d1923))
* **internal:** support passing arguments to test script ([49c1ff1](https://github.com/Mac74marvelous/bc-kotlin/commit/49c1ff193211443bd907f0eafc270b1f0b4e552d))
* **internal:** support running formatters directly ([8156508](https://github.com/Mac74marvelous/bc-kotlin/commit/8156508fbce420613718c660fd7f5645f0c70a79))
* **internal:** unskip some tests ([88c1607](https://github.com/Mac74marvelous/bc-kotlin/commit/88c160742e9eda7c76fee35612b10bb08d09db72))
* **internal:** update comment in script ([a28e12d](https://github.com/Mac74marvelous/bc-kotlin/commit/a28e12d12d030db452a498fd66ab49b3c5b82211))
* sync repo ([36d6968](https://github.com/Mac74marvelous/bc-kotlin/commit/36d6968cde1a2ae742ad8021a7cfb8c05e820b9a))
* update @stainless-api/prism-cli to v5.15.0 ([036f733](https://github.com/Mac74marvelous/bc-kotlin/commit/036f733d114c685fe9be1fdc3fa41265065bba86))
* update SDK settings ([d1ad022](https://github.com/Mac74marvelous/bc-kotlin/commit/d1ad0228f830e3619cbc878eb4790cc22ebcfd86))


### Documentation

* fix missing readme comment ([7ee006c](https://github.com/Mac74marvelous/bc-kotlin/commit/7ee006c8f523b3f78b14651647ed6cbd76024fa3))
* more code comments ([d3059fe](https://github.com/Mac74marvelous/bc-kotlin/commit/d3059fe30a94120591f71abb4e02c277fd8d50dd))

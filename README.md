# CodeQL Workflows
In this project, we provide examples of writing workflows using CodeQL to scan code in various languages such as Python, Java, .NET, and Terraform.

## Project Structure

- **.github/workflows:**
  - dotnet-scan
  - java-scan
  - python-scan
  - terraform-scan

- **dotnet-code-folder:** 
- **java-code-folder:** 
- **python-code-folder:** 
- **terraform-code-folder:** 

### Workflows
The .github/workflows folder contains workflows used to scan code in different languages, including:
- **dotnet-scan:** Workflow for scanning .NET code
- **java-scan:** Workflow for scanning Java code
- **python-scan:** Workflow for scanning Python code
- **terraform-scan:** Workflow for scanning Terraform code

### Code Folders
The dotnet-code-folder, java-code-folder, python-code-folder, and terraform-code-folder contain sample code written in the specified languages.

## Usage CodeQL in Workflows
### -For .NET, Java, and Python, use github/codeql-action
Add the following steps to the workflow

1. **Initialize CodeQL tools for scanning**
   ```yaml
   - name: Initialize CodeQL
     uses: github/codeql-action/init@v1
     with:
       languages: ${{ matrix.language }}

2. **Autobuild attempts to build any compiled languages (C/C++, C#, or Java)**
    ```yaml
    - name: Autobuild
      uses: github/codeql-action/autobuild@v1

This step automatically builds the code.

3. **Scan and analyze code with CodeQL**
    ```yaml
    - name: Perform CodeQL Analysis
      uses: github/codeql-action/analyze@v1

### -For Terraform, use advanced-security/codeql-extractor-iac
Add the following steps to the workflow

1. **Initialize and Analyze IaC**
   ```yaml
    - name: Initialize and Analyze IaC
      id: codeql_iac
      uses: advanced-security/codeql-extractor-iac@main


2. **Upload SARIF file**
Since the CodeQL Extractor generates a SARIF file but doesn't upload it, use github/codeql-action/upload-sarif to manually upload the file.

    ```yaml
    - name: Upload SARIF file
      uses: github/codeql-action/upload-sarif@v2
      with:
      sarif_file: codeql-iac.sarif

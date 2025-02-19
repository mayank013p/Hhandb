package com.example.Helph4iso;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CertificationController {

    @PostMapping("/certifications/details")
    public Certification getCertificationDetails(@RequestBody CertificationRequest request) {
        // Logic to retrieve detailed certification information based on the request
        switch (request.getId()) {
            case "iso-9001":
                return new Certification(
                    request.getId(),
                    "ISO 9001",
                    "Quality Management System",
                    "ISO 9001 is an international standard that specifies requirements for a quality management system (QMS). Organizations use the standard to demonstrate the ability to consistently provide products and services that meet customer and regulatory requirements. It is one of the most widely used standards globally and is applicable to organizations of all sizes and industries.\n\n" +
                    "### Key Benefits of ISO 9001\n" +
                    "- **Improved Customer Satisfaction**: By consistently meeting customer requirements, organizations can enhance customer satisfaction and loyalty.\n" +
                    "- **Operational Efficiency**: Streamlined processes and reduced waste lead to improved efficiency and cost savings.\n" +
                    "- **Risk Management**: Identifying and mitigating risks helps organizations avoid potential issues and improve resilience.\n" +
                    "- **Continuous Improvement**: The standard promotes a culture of continuous improvement, helping organizations stay competitive.\n\n" +
                    "### Implementation Steps\n" +
                    "1. **Gap Analysis**: Assess current processes against ISO 9001 requirements.\n" +
                    "2. **Documentation**: Develop necessary documentation, including a quality manual and procedures.\n" +
                    "3. **Training**: Train employees on the QMS and their roles within it.\n" +
                    "4. **Internal Audit**: Conduct internal audits to ensure compliance.\n" +
                    "5. **Certification Audit**: Engage a certification body to perform the certification audit.\n\n" +
                    "### Application Form\n" +
                    "To apply for ISO 9001 certification, please download the application form from our website and submit it along with the required documentation."
                );
            case "iso-14001":
                return new Certification(
                    request.getId(),
                    "ISO 14001",
                    "Environmental Management System",
                    "ISO 14001 is an international standard that specifies requirements for an environmental management system (EMS). It helps organizations improve their environmental performance through more efficient use of resources and reduction of waste.\n\n" +
                    "### Key Benefits of ISO 14001\n" +
                    "- **Regulatory Compliance**: Ensures compliance with environmental regulations and reduces the risk of fines.\n" +
                    "- **Resource Efficiency**: Promotes efficient use of resources, leading to cost savings.\n" +
                    "- **Corporate Image**: Enhances the organization's reputation as an environmentally responsible entity.\n" +
                    "- **Sustainable Practices**: Encourages sustainable practices and reduces environmental impact.\n\n" +
                    "### Implementation Steps\n" +
                    "1. **Environmental Policy**: Develop an environmental policy that reflects the organization's commitment to environmental management.\n" +
                    "2. **Planning**: Identify environmental aspects and impacts, and set objectives and targets.\n" +
                    "3. **Implementation**: Develop and implement procedures to achieve the objectives.\n" +
                    "4. **Monitoring and Measurement**: Monitor and measure environmental performance and take corrective actions as needed.\n" +
                    "5. **Certification Audit**: Engage a certification body to perform the certification audit.\n\n" +
                    "### Application Form\n" +
                    "To apply for ISO 14001 certification, please download the application form from our website and submit it along with the required documentation."
                );
            case "iso-27001":
                return new Certification(
                    request.getId(),
                    "ISO 27001",
                    "Information Security Management System",
                    "ISO 27001 is an international standard that specifies requirements for an information security management system (ISMS). It helps organizations manage and protect their information assets, ensuring confidentiality, integrity, and availability.\n\n" +
                    "### Key Benefits of ISO 27001\n" +
                    "- **Risk Management**: Identifies and mitigates risks to information security.\n" +
                    "- **Regulatory Compliance**: Ensures compliance with data protection regulations.\n" +
                    "- **Customer Trust**: Enhances customer trust by demonstrating a commitment to information security.\n" +
                    "- **Business Continuity**: Improves business continuity planning and reduces the risk of data breaches.\n\n" +
                    "### Implementation Steps\n" +
                    "1. **Risk Assessment**: Identify and assess risks to information security.\n" +
                    "2. **Policy Development**: Develop an information security policy and procedures.\n" +
                    "3. **Implementation**: Implement controls to mitigate identified risks.\n" +
                    "4. **Monitoring and Review**: Continuously monitor and review the ISMS.\n" +
                    "5. **Certification Audit**: Engage a certification body to perform the certification audit.\n\n" +
                    "### Application Form\n" +
                    "To apply for ISO 27001 certification, please download the application form from our website and submit it along with the required documentation."
                );
            default:
                return null; // or throw an exception
        }
    }
}

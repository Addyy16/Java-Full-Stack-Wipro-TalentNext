<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <head>
        <title>Mobile Showroom Sales Report</title>
        <style>
          table { border-collapse: collapse; width: 80%; }
          th, td { border: 1px solid black; padding: 8px; text-align: left; }
          th { background-color: #f2f2f2; }
        </style>
      </head>
      <body>
        <h2>Sales Report of Mobile Showroom Branches</h2>
        <xsl:for-each select="MobileShowroom/Branch">
          <h3><xsl:value-of select="@name"/></h3>
          <table>
            <tr>
              <th>Model ID</th>
              <th>Model Name</th>
              <th>Price</th>
              <th>Quantity Sold</th>
            </tr>
            <xsl:for-each select="Mobile">
              <tr>
                <td><xsl:value-of select="@modelId"/></td>
                <td><xsl:value-of select="ModelName"/></td>
                <td><xsl:value-of select="Price"/></td>
                <td><xsl:value-of select="QuantitySold"/></td>
              </tr>
            </xsl:for-each>
          </table>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>

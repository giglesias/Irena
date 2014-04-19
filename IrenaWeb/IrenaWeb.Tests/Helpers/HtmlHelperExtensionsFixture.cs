namespace IrenaWeb.Tests.Helpers
{
    using System;
    using System.Web;
    using IrenaWeb.Helpers;
    using IrenaWeb.Models;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class HtmlHelperExtensionsFixture
    {
        [TestMethod]
        public void GenerateRelayQrCode_ShouldEncodeMedicalHistoryInAImgHtmlTag()
        {
            // Arrange
            var medicalHistory = new HistoriaClinica();

            // Act
            var actual = medicalHistory.GenerateRelayQrCode();

            // Arrange
            Assert.IsNotNull(actual);
            Assert.IsTrue(actual.ToString().Contains("<img"));
        }
    }
}
